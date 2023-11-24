import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String userID;
    private String username;
    private String email;
    private String profilePicture;
    private String bio;
    private List<Post> userPosts;
    private List<UserProfile> followers;
    private List<UserProfile> following;

    public UserProfile(String userID, String username, String email) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.userPosts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void createPost(String caption, String image) {
        Post post = new Post(caption, image, this);
        userPosts.add(post);
    }

    public void deletePost(Post post) {
        userPosts.remove(post);
    }

    public void followUser(UserProfile user) {
        following.add(user);
        user.followers.add(this);
    }

    public void unfollowUser(UserProfile user) {
        following.remove(user);
        user.followers.remove(this);
    }

    public void viewFeed() {
        for (UserProfile user : following) {
            for (Post post : user.userPosts) {
                post.viewPost();
            }
        }
    }

    public static UserProfile loadUserProfileFromFile(String userID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(userID)) {
                    return new UserProfile(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // User not found in the file
    }
}
