package com.example.api.persistence.mappers;

import com.example.api.domain.entities.TypeDocument;
import com.example.api.persistence.models.TypeDocumentDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T11:15:18-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class TypeDocumentMapperImpl implements TypeDocumentMapper {

    @Override
    public TypeDocument toTypeDocument(TypeDocumentDAO dao) {
        if ( dao == null ) {
            return null;
        }

        TypeDocument typeDocument = new TypeDocument();

        if ( dao.getIdTypeDocument() != null ) {
            typeDocument.setIdTypeDocument( dao.getIdTypeDocument() );
        }
        typeDocument.setName( dao.getName() );

        return typeDocument;
    }

    @Override
    public List<TypeDocument> toTypeDocuments(List<TypeDocumentDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<TypeDocument> list = new ArrayList<TypeDocument>( daos.size() );
        for ( TypeDocumentDAO typeDocumentDAO : daos ) {
            list.add( toTypeDocument( typeDocumentDAO ) );
        }

        return list;
    }

    @Override
    public TypeDocumentDAO toTypeDocumentDAO(TypeDocument document) {
        if ( document == null ) {
            return null;
        }

        TypeDocumentDAO typeDocumentDAO = new TypeDocumentDAO();

        typeDocumentDAO.setIdTypeDocument( document.getIdTypeDocument() );
        typeDocumentDAO.setName( document.getName() );

        return typeDocumentDAO;
    }
}
