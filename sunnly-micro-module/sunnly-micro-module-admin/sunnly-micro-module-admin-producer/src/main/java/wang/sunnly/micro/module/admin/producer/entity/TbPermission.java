package wang.sunnly.micro.module.admin.producer.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_permission")
public class TbPermission {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 父权限
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 权限名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 机器识别的权限名称
     */
    @Column(name = "enname")
    private String enname;

    /**
     * 授权路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 备注
     */
    @Column(name = "description")
    private String description;

    /**
     * 请求方式 get post update delete
     */
    @Column(name = "`method`")
    private String method;

    /**
     * 展示方式：menu button href
     */
    @Column(name = "display")
    private String display;

    /**
     * Vue引入界面
     */
    @Column(name = "imports")
    private String imports;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父权限
     *
     * @return parent_id - 父权限
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父权限
     *
     * @param parentId 父权限
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取机器识别的权限名称
     *
     * @return enname - 机器识别的权限名称
     */
    public String getEnname() {
        return enname;
    }

    /**
     * 设置机器识别的权限名称
     *
     * @param enname 机器识别的权限名称
     */
    public void setEnname(String enname) {
        this.enname = enname;
    }

    /**
     * 获取授权路径
     *
     * @return url - 授权路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置授权路径
     *
     * @param url 授权路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取备注
     *
     * @return description - 备注
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置备注
     *
     * @param description 备注
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取请求方式 get post update delete
     *
     * @return method - 请求方式 get post update delete
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求方式 get post update delete
     *
     * @param method 请求方式 get post update delete
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取展示方式：menu button href
     *
     * @return display - 展示方式：menu button href
     */
    public String getDisplay() {
        return display;
    }

    /**
     * 设置展示方式：menu button href
     *
     * @param display 展示方式：menu button href
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * 获取Vue引入界面
     *
     * @return imports - Vue引入界面
     */
    public String getImports() {
        return imports;
    }

    /**
     * 设置Vue引入界面
     *
     * @param imports Vue引入界面
     */
    public void setImports(String imports) {
        this.imports = imports;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}