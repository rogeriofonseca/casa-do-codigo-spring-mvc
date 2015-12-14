package org.casadocodigo.loja.infra;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private AmazonS3Client s3;
    
    public String write(String baseFolder, MultipartFile multipartFile){
        try{
            s3.putObject("casadocodigo", multipartFile.getOriginalFilename(), multipartFile.getInputStream(), new ObjectMetadata());
            
            //url de acesso ao arquivo
            return "https://s3.amazonaws.com/casadocodigo/"+multipartFile.getOriginalFilename()+"?noAuth=true";
        }catch(AmazonClientException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
