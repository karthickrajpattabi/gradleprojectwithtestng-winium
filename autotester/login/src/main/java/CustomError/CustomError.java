package CustomError;

public class CustomError extends Exception{
    String errormsg="";
    public   CustomError(String err){
        this.errormsg = err;
    }

    @Override
    public String getMessage() {
        return this.errormsg;
    }
}
