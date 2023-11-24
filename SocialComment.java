public class SocialComment {
    private String commentText;
    private UserProfile author;
    private SocialPost post;

    public SocialComment(String commentText, UserProfile author, SocialPost post) {
        this.commentText = commentText;
        this.author = author;
        this.post = post;
    }

    public void displayComment() {
        System.out.println("Author: " + author.getUsername());
        System.out.println("Comment Text: " + commentText);
    }
}

