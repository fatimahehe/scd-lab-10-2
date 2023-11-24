import java.util.ArrayList;
import java.util.List;

public class SocialPost {
    private String postCaption;
    private String postImage;
    private UserProfile author;
    private List<Comment> postComments;
    private List<UserProfile> postLikes;

    public SocialPost(String postCaption, String postImage, UserProfile author) {
        this.postCaption = postCaption;
        this.postImage = postImage;
        this.author = author;
        this.postComments = new ArrayList<>();
        this.postLikes = new ArrayList<>();
    }

    public void displayPost() {
        System.out.println("Author: " + author.getUsername());
        System.out.println("Caption: " + postCaption);
        System.out.println("Image: " + postImage);
        System.out.println("Likes: " + postLikes.size());
        System.out.println("Comments:");
        for (Comment comment : postComments) {
            comment.displayComment();
        }
    }

    public void addComment(UserProfile user, String text) {
        Comment comment = new Comment(text, user, this);
        postComments.add(comment);
    }

    public void addLike(UserProfile user) {
        postLikes.add(user);
    }

    public void removeLike(UserProfile user) {
        postLikes.remove(user);
    }
}
