/**   
 * Post
 *  
 * @author http://fuxinci.com
 * Date: May 18, 2012
 */
package org.fxc.woblog.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.fxc.woblog.domain.enmu.CommentStatus;
import org.fxc.woblog.domain.enmu.PingStatus;
import org.fxc.woblog.domain.enmu.PostStatus;
import org.fxc.woblog.domain.enmu.PostType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name="wb_post")
public class Post extends BaseModel
{
    /**
     * 对应作者ID
     */
    private String author;
    /**
     * 发布时间
     */
    @Column(columnDefinition="DATE default sysdate")
    private Date createDate;
    /**
     * 正文
     */
    @NotNull
    @Column(columnDefinition="CLOB")
    private String content;
    /**
     * 标题
     */
    @NotNull
    @Size(min=1, max=25)
    private String title;
    /**
     * 摘录
     */
    @Column(columnDefinition="CLOB")
    private String excerpt;
    /**
     * 文章状态（publish/auto-draft/inherit等）
     */
    private PostStatus postStatus;
    /**
     * 评论状态（open/closed）
     */
    private CommentStatus commentStatus;
    /**
     * PING状态（open/closed）
     */
    private PingStatus pingStatus;
    /**
     * 文章密码
     */
    private String password;
    /**
     * 文章缩略名
     */
    private String postName;
    /**
     * 修改时间
     */
    @Column(columnDefinition="DATE")
    private Date modifiedDate;
    /**
     * 未知
     */
    private String postContentFiltered;
    /**
     * 父文章，主要用于PAGE
     */
    private String parent;
    /**
     * 未知
     */
    private String guid;
    /**
     * 排序ID
     */
    private int menuOrder;
    /**
     * 文章类型（post/page等）
     */
    private PostType postType;
    /**
     * 评论总数
     */
    private int commentCount = 0;

    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "postId")
    private Set<PostTerm> postTerms = new HashSet<PostTerm>();

    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "postId")
    private Set<Comment> comments = new HashSet<Comment>();

    public void addPostTerm(PostTerm postTerm){
        postTerms.add(postTerm);
    }

    public Set<PostTerm> getPostTerms() {
        return postTerms;
    }

    public void setPostTerms(Set<PostTerm> postTerms) {
        this.postTerms = postTerms;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PingStatus getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(PingStatus pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
