package wang.sunnly.micro.common.web.msg;
import java.util.List;

public class TableResultResponse<E> extends BaseResponse {

    TableData<E> data;

    public TableResultResponse(long total, List<E> rows) {
        this.data = new TableData<E>(total, rows);
    }

    public TableResultResponse(int status, String message){
        this.data = new TableData<E>();
        this.setMessage(message);
        this.setStatus(status);
    }

    public TableResultResponse() {
        this.data = new TableData<E>();
    }

    TableResultResponse<E> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<E> total(List<E> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<E> getData() {
        return data;
    }

    public void setData(TableData<E> data) {
        this.data = data;
    }

    class TableData<E> {
        long total;
        List<E> rows;

        public TableData(long total, List<E> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<E> getRows() {
            return rows;
        }

        public void setRows(List<E> rows) {
            this.rows = rows;
        }
    }
}
