package com.example.api.persistence.mappers;

import com.example.api.domain.entities.User;
import com.example.api.persistence.models.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T11:15:18-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private TypeDocumentMapper typeDocumentMapper;

    @Override
    public User toUser(UserDAO dao) {
        if ( dao == null ) {
            return null;
        }

        User user = new User();

        if ( dao.getIdUser() != null ) {
            user.setUserId( dao.getIdUser() );
        }
        user.setName( dao.getName() );
        user.setLastname( dao.getLastname() );
        user.setAge( dao.getAge() );
        user.setCity( dao.getCity() );
        user.setIdenticationNumber( dao.getIdenticationNumber() );
        user.setDocumentTypeId( dao.getDocumentTypeId() );
        user.setTypeDocument( typeDocumentMapper.toTypeDocument( dao.getDocumentType() ) );

        return user;
    }

    @Override
    public List<User> toUsers(List<UserDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( daos.size() );
        for ( UserDAO userDAO : daos ) {
            list.add( toUser( userDAO ) );
        }

        return list;
    }

    @Override
    public UserDAO toUserDAO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDAO userDAO = new UserDAO();

        userDAO.setIdUser( user.getUserId() );
        userDAO.setName( user.getName() );
        userDAO.setLastname( user.getLastname() );
        userDAO.setAge( user.getAge() );
        userDAO.setCity( user.getCity() );
        userDAO.setIdenticationNumber( user.getIdenticationNumber() );
        userDAO.setDocumentTypeId( user.getDocumentTypeId() );
        userDAO.setDocumentType( typeDocumentMapper.toTypeDocumentDAO( user.getTypeDocument() ) );

        return userDAO;
    }
}
