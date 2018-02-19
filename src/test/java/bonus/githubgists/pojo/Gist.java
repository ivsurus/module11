package bonus.githubgists.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"description",
"public",
"url",
"forks_url",
"commits_url",
"id",
"owner",
"user",
"files",
"truncated",
"comments",
"comments_url",
"html_url",
"git_pull_url",
"git_push_url",
"created_at",
"updated_at"
})
public class Gist {

	@JsonProperty("url")
	private String url;
	@JsonProperty("forks_url")
	private String forksUrl;
	@JsonProperty("commits_url")
	private String commitsUrl;
	@JsonProperty("id")
	private String id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("public")
	private Boolean _public;
	@JsonProperty("owner")
	private Owner owner;
	@JsonProperty("user")
	private Object user;
	@JsonProperty("files")
	private Files files;
	@JsonProperty("truncated")
	private Boolean truncated;
	@JsonProperty("comments")
	private Integer comments;
	@JsonProperty("comments_url")
	private String commentsUrl;
	@JsonProperty("html_url")
	private String htmlUrl;
	@JsonProperty("git_pull_url")
	private String gitPullUrl;
	@JsonProperty("git_push_url")
	private String gitPushUrl;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("url")
	public String getUrl() {
	return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
	this.url = url;
	}

	@JsonProperty("forks_url")
	public String getForksUrl() {
	return forksUrl;
	}

	@JsonProperty("forks_url")
	public void setForksUrl(String forksUrl) {
	this.forksUrl = forksUrl;
	}

	@JsonProperty("commits_url")
	public String getCommitsUrl() {
	return commitsUrl;
	}

	@JsonProperty("commits_url")
	public void setCommitsUrl(String commitsUrl) {
	this.commitsUrl = commitsUrl;
	}

	@JsonProperty("id")
	public String getId() {
	return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
	}

	@JsonProperty("description")
	public String getDescription() {
	return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
	this.description = description;
	}

	@JsonProperty("public")
	public Boolean getPublic() {
	return _public;
	}

	@JsonProperty("public")
	public void setPublic(Boolean _public) {
	this._public = _public;
	}

	@JsonProperty("owner")
	public Owner getOwner() {
	return owner;
	}

	@JsonProperty("owner")
	public void setOwner(Owner owner) {
	this.owner = owner;
	}

	@JsonProperty("user")
	public Object getUser() {
	return user;
	}

	@JsonProperty("user")
	public void setUser(Object user) {
	this.user = user;
	}

	@JsonProperty("files")
	public Files getFiles() {
	return files;
	}

	@JsonProperty("files")
	public void setFiles(Files files) {
	this.files = files;
	}

	@JsonProperty("truncated")
	public Boolean getTruncated() {
	return truncated;
	}

	@JsonProperty("truncated")
	public void setTruncated(Boolean truncated) {
	this.truncated = truncated;
	}

	@JsonProperty("comments")
	public Integer getComments() {
	return comments;
	}

	@JsonProperty("comments")
	public void setComments(Integer comments) {
	this.comments = comments;
	}

	@JsonProperty("comments_url")
	public String getCommentsUrl() {
	return commentsUrl;
	}

	@JsonProperty("comments_url")
	public void setCommentsUrl(String commentsUrl) {
	this.commentsUrl = commentsUrl;
	}

	@JsonProperty("html_url")
	public String getHtmlUrl() {
	return htmlUrl;
	}

	@JsonProperty("html_url")
	public void setHtmlUrl(String htmlUrl) {
	this.htmlUrl = htmlUrl;
	}

	@JsonProperty("git_pull_url")
	public String getGitPullUrl() {
	return gitPullUrl;
	}

	@JsonProperty("git_pull_url")
	public void setGitPullUrl(String gitPullUrl) {
	this.gitPullUrl = gitPullUrl;
	}

	@JsonProperty("git_push_url")
	public String getGitPushUrl() {
	return gitPushUrl;
	}

	@JsonProperty("git_push_url")
	public void setGitPushUrl(String gitPushUrl) {
	this.gitPushUrl = gitPushUrl;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
	return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
	return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Gist [url=" + url + ", forksUrl=" + forksUrl + ", commitsUrl=" + commitsUrl + ", id=" + id
				+ ", description=" + description + ", _public=" + _public + ", owner=" + owner + ", user=" + user
				+ ", files=" + files + ", truncated=" + truncated + ", comments=" + comments + ", commentsUrl="
				+ commentsUrl + ", htmlUrl=" + htmlUrl + ", gitPullUrl=" + gitPullUrl + ", gitPushUrl=" + gitPushUrl
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", additionalProperties="
				+ additionalProperties + "]";
	}
}
