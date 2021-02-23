package dto.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConsTructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsContructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response <t> {
    private t data;
    private Object errors;

    public void addErrorMsgToResponse(String msgError){
        ResponseError error = new ResponseError().setDetails(msgError).setTimestamp(LocalDateTime.now());
        setErrors(error);
    }
}
