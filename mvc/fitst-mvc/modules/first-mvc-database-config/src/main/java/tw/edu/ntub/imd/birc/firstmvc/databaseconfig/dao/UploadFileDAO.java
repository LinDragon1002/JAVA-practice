package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.UploadFile;

import java.util.List;

@Repository
public interface UploadFileDAO extends BaseDAO<UploadFile, Integer> {
    List<UploadFile> findAllByTableid(Integer id);
//    @Query("SELECT a.name FROM UploadFile a WHERE a.id = :id")
//    List<UploadFile> findAllById(@Param("id") Integer id);
}
