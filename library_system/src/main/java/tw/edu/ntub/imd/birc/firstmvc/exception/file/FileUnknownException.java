package tw.edu.ntub.imd.birc.firstmvc.exception.file;

public class FileUnknownException extends FileException {
    public FileUnknownException(Throwable cause) {
        super("未知錯誤", cause);
    }

    @Override
    public String getReason() {
        return "Unknown";
    }
}
