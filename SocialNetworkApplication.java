public class SocialNetworkApplication {
    public static void main(String[] args) {
        UserProfile userProfile1 = new UserProfile("1", "user1", "user1@example.com");
        UserProfile userProfile2 = new UserProfile("2", "user2", "user2@example.com");

        userProfile1.createPost("My first post", "image1.jpg");
        userProfile1.createPost("Another post", "image2.jpg");
        userProfile2.createPost("User2's post", "image3.jpg");

        userProfile1.followUser(userProfile2);

        userProfile1.viewFeed();
    }
}
