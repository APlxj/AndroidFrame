package ap.com.httpclient;

/**
 * 类描述：文件bean
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class FileBean {

    public FileBean() {
    }

    public FileBean(Bulider bulider) {
        this.filePath = bulider.filePath;
        this.fileName = bulider.fileName;
        this.downloadLength = bulider.downloadLength;
        this.directory = bulider.directory;
        this.contentLength = bulider.contentLength;
    }

    //文件路径
    private String filePath;
    //文件名称
    private String fileName;
    //已下载文件长度
    private long downloadLength;
    //文件保存目录
    private String directory;
    //文件总大小
    private long contentLength;

    public String getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public long getDownloadLength() {
        return downloadLength;
    }

    public String getDirectory() {
        return directory;
    }

    public long getContentLength() {
        return contentLength;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", downloadLength=" + downloadLength +
                ", directory='" + directory + '\'' +
                ", contentLength=" + contentLength +
                '}';
    }

    public static class Bulider {
        //文件路径
        private String filePath;
        //文件名称
        private String fileName;
        //已下载文件长度
        private long downloadLength;
        //文件保存目录
        private String directory;
        //文件总大小
        private long contentLength;

        public Bulider filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Bulider fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Bulider downloadLength(long downloadLength) {
            this.downloadLength = downloadLength;
            return this;
        }

        public Bulider directory(String directory) {
            this.directory = directory;
            return this;
        }

        public Bulider contentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        public FileBean bulid() {
            return new FileBean(this);
        }
    }
}
