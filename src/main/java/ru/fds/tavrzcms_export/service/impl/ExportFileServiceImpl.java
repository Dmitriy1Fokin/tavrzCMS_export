package ru.fds.tavrzcms_export.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.fds.tavrzcms_export.domain.ExportFile;
import ru.fds.tavrzcms_export.service.ExportFileService;

import java.io.IOException;
import java.util.Optional;

@Service
public class ExportFileServiceImpl implements ExportFileService {

    private final GridFsTemplate gridFsTemplate;
    private final GridFsOperations operations;

    public ExportFileServiceImpl(GridFsTemplate gridFsTemplate,
                                 GridFsOperations operations) {
        this.gridFsTemplate = gridFsTemplate;
        this.operations = operations;
    }

    @Override
    public String addFile(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }

    @Override
    public Optional<ExportFile> getFile(String id) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

        ExportFile exportFile = new ExportFile();

        assert file != null;
        assert file.getMetadata() != null;

        exportFile.setTitle(file.getMetadata().get("title").toString());
        exportFile.setFile(operations.getResource(file).getInputStream());

        return Optional.of(exportFile);
    }
}
