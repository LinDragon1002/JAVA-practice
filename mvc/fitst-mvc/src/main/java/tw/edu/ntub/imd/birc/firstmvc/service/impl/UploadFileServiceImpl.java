package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.UploadFileBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.UploadFileDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.UploadFile;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.MultipartFileUploader;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.UploadResult;
import tw.edu.ntub.imd.birc.firstmvc.service.UploadFileService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.UploadFileTransformer;

import java.time.LocalDate;
import java.util.List;


//告訴spring這是一個service
@Service
//要實作介面，DAO、transformer為建構元傳入參數(DAO不一定只有一個，依需求)
public class UploadFileServiceImpl extends BaseServiceImpl<UploadFileBean, UploadFile, Integer> implements UploadFileService {
    private final UploadFileDAO uploadFileDAO;
    private final UploadFileTransformer transformer;
    private final MultipartFileUploader multipartFileUploader;

    public UploadFileServiceImpl(UploadFileDAO uploadFileDAO,
                                 UploadFileTransformer uploadFileTransformer,
                                 MultipartFileUploader multipartFileUploader) {
        super(uploadFileDAO, uploadFileTransformer);
        this.uploadFileDAO = uploadFileDAO;
        this.transformer = uploadFileTransformer;
        this.multipartFileUploader = multipartFileUploader;
    }

    @Override
    public UploadFileBean save(UploadFileBean uploadFileBean) {

        UploadResult uploadResult = multipartFileUploader.upload(uploadFileBean.getFile(),"protected", uploadFileBean.getTable_name(), uploadFileBean.getTable_id().toString());
//
        uploadFileBean.setPath(uploadResult.getUrl());

        UploadFile uploadFile = uploadFileDAO.save(transformer.transferToEntity(uploadFileBean));
        return transformer.transferToBean(uploadFile);
    }

//    @Override
//    public List<UploadFileBean> findAllById(Integer id) {
//        return CollectionUtils.map(uploadFileDAO.findAllById(id), transformer::transferToBean);
//    }
}
