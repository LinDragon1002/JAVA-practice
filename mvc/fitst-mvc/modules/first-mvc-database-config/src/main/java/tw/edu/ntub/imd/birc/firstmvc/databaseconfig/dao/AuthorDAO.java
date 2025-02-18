package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;

import java.util.List;

@Repository
public interface AuthorDAO extends BaseDAO<Author, Integer> {
    List<Author> findAllById(Integer id);

    @Query("SELECT a.name FROM Author a WHERE a.id = :id")
    List<Author> findAllByName(@Param("id") Integer id);

//    CRUD creat read update delete
}
