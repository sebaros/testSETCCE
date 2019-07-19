
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "logs")
public class Log {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
@Column(name = "date")
private Date date;
@Column(name = "logMsg")
private String logMsg;

public Log() {
}

public Log(Date date, String logMsg) {
    this.date = date;
    this.logMsg = logMsg;

}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public Date getDate() {
    return date;
}
public void setDate(Date date) {
    this.date = date;
}
public String getLogMsg() {
    return logMsg;
}
public void setLogMsg(String logMsg) {
    this.logMsg = logMsg;
}

@Override
public String toString() {
    return "Log [id=" + id + ", date=" + date.toString() + ", logmsg=" + logMsg + "]";
}
}