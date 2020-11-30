package sistemas.escuelaing.edu.co.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import sistemas.escuelaing.edu.co.domain.enumeration.PostType;

/**
 * A Post.
 */
@Document(collection = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @NotNull
    @Field("type")
    private PostType type;

    @NotNull
    @Field("description")
    private String description;

    @NotNull
    @Field("publish_date")
    private Instant publishDate;

    @Field("resolved_date")
    private LocalDate resolvedDate;

    @DBRef
    @Field("item")
    private Set<Item> items = new HashSet<>();

    @DBRef
    @Field("tag")
    private Set<Tag> tags = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Post name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostType getType() {
        return type;
    }

    public Post type(PostType type) {
        this.type = type;
        return this;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public Post description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getPublishDate() {
        return publishDate;
    }

    public Post publishDate(Instant publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public void setPublishDate(Instant publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getResolvedDate() {
        return resolvedDate;
    }

    public Post resolvedDate(LocalDate resolvedDate) {
        this.resolvedDate = resolvedDate;
        return this;
    }

    public void setResolvedDate(LocalDate resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Post items(Set<Item> items) {
        this.items = items;
        return this;
    }

    public Post addItem(Item item) {
        this.items.add(item);
        item.setPost(this);
        return this;
    }

    public Post removeItem(Item item) {
        this.items.remove(item);
        item.setPost(null);
        return this;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Post tags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Post addTag(Tag tag) {
        this.tags.add(tag);
        tag.setPost(this);
        return this;
    }

    public Post removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.setPost(null);
        return this;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        return id != null && id.equals(((Post) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Post{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", description='" + getDescription() + "'" +
            ", publishDate='" + getPublishDate() + "'" +
            ", resolvedDate='" + getResolvedDate() + "'" +
            "}";
    }
}
