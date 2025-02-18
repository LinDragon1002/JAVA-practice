//package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;
//
//
//import lombok.Data;
//import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
//import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.UploadFileListener;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//@EntityListeners(UploadFileListener.class)
//@Table(name = "upload", schema = Config.DATABASE_NAME)
//public class UploadFile {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @Column(name = "path",length = 500, nullable = false)
//    private String path;
//
//    @Column(name = "name", length = 45 , nullable = false)
//    private String name;
//
//    @Column(name = "create_time", nullable = false)
//    private LocalDateTime create_time;
//
//    @OneToMany(mappedBy = "uploadFile", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UploadFile> files;
//
//
//}
