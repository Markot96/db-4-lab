package com.markot.view;

import com.markot.controller.impl.*;
import com.markot.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private final AdressController adressController = new AdressController();
    private final AvatarController avatarController = new AvatarController();
    private final CommentsController commentsController = new CommentsController();
    private final PasswordController passwordController = new PasswordController();
    private final ReactionsController reactionsController = new ReactionsController();
    private final StoryController storyController = new StoryController();
    private final StoryLineController storyLineController = new StoryLineController();
    private final UserController userController = new UserController();

    private final Map<String, Printable> menu = new LinkedHashMap<>();


    public View() {
        menu.put("11", this::getAllAdress);
        menu.put("12", this::getAdressById);
        menu.put("13", this::createAdress);
        menu.put("14", this::updateAdress);
        menu.put("15", this::deleteAdress);

        menu.put("21", this::getAllAvatar);
        menu.put("22", this::getAvatarById);
        menu.put("23", this::createAvatar);
        menu.put("24", this::updateAvatar);
        menu.put("25", this::deleteAvatar);

        menu.put("31", this::getAllComments);
        menu.put("32", this::getCommentsById);
        menu.put("33", this::createComments);
        menu.put("34", this::updateComments);
        menu.put("35", this::deleteComments);

        menu.put("41", this::getAllPassword);
        menu.put("42", this::getPasswordById);
        menu.put("43", this::createPassword);
        menu.put("44", this::updatePassword);
        menu.put("45", this::deletePassword);

        menu.put("51", this::getAllReactions);
        menu.put("52", this::getReactionsById);
        menu.put("53", this::createReactions);
        menu.put("54", this::updateReactions);
        menu.put("55", this::deleteReactions);

        menu.put("61", this::getAllStory);
        menu.put("62", this::getStoryById);
        menu.put("63", this::createStory);
        menu.put("64", this::updateStory);
        menu.put("65", this::deleteStory);

        menu.put("71", this::getAllStoryLine);
        menu.put("72", this::getStoryLineById);
        menu.put("73", this::createStoryLine);
        menu.put("74", this::updateStoryLine);
        menu.put("75", this::deleteStoryLine);

        menu.put("81", this::getAllUser);
        menu.put("82", this::getUserById);
        menu.put("83", this::createUser);
        menu.put("84", this::updateUser);
        menu.put("85", this::deleteUser);
    }

    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - adress                       |         1 - GET ALL");
        System.out.println("  2 - avatar                       |         2 - GET ONE");
        System.out.println("  3 - comments                     |         3 - CREATE");
        System.out.println("  4 - password                     |         4 - UPDATE");
        System.out.println("  5 - reactions                    |         5 - DELETE");
        System.out.println("  6 - story");
        System.out.println("  7 - story line");
        System.out.println("  8 - user");
        System.out.println("E.G. adresses (X=1) - get all (Y=1): 11");
        System.out.println("     comments (X=3) - update (Y=4): 34");
        System.out.println("     password (X=4) - get one (Y=2): 42");
        System.out.println("=======================================================================");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose parameter:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

//adresses
    private void getAllAdress() throws SQLException {
        System.out.println("\n[ADRESS / GET]");
        System.out.println(adressController.findAll() + "\n");
    }

    private void getAdressById() throws SQLException {
        System.out.println("\n[ADRESS / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(adressController.findOne(id) + "\n");
    }

    private Adress getAdressInputs() {
        System.out.println("\nEnter color: ");
        String color = SCANNER.next();

        return new Adress(color);
    }

    private void createAdress() throws SQLException {
        System.out.println("\n[ADRESS / CREATE]");
        Adress adress = getAdressInputs();
        adressController.create(adress);
        System.out.println("ADRESS created.\n");
    }

    private void updateAdress() throws SQLException {
        System.out.println("\n[ADRESS / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Adress adress = getAdressInputs();
        adress.setId(id);

        adressController.update(adress.getId(), adress);
        System.out.println("ADRESS with ID=" + id + " successfully updated\n");
    }

    private void deleteAdress() throws SQLException {
        System.out.println("\n[ADRESS / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        adressController.delete(id);
        System.out.println("ADRESS with ID=" + id + " successfully deleted\n");
    }

//  avatars
    private void getAllAvatar() throws SQLException {
        System.out.println("\n[AVATAR / GET]");
        System.out.println(avatarController.findAll() + "\n");
    }

    private void getAvatarById() throws SQLException {
        System.out.println("\n[AVATAR / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(avatarController.findOne(id) + "\n");
    }

    private Avatar getAvatarInputs() {
        System.out.println("\nEnter file name: ");
        String file_name = SCANNER.next();
        System.out.println("\nEnter file size in mb: ");
        Float file_size_in_mb = SCANNER.nextFloat();

        return new Avatar(file_name, file_size_in_mb);
    }

    private void createAvatar() throws SQLException {
        System.out.println("\n[AVATAR / CREATE]");
        Avatar avatar = getAvatarInputs();
        avatarController.create(avatar);
        System.out.println("AVATAR created.\n");
    }

    private void updateAvatar() throws SQLException {
        System.out.println("\n[AVATAR / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Avatar avatar = getAvatarInputs();
        avatar.setId(id);

        avatarController.update(avatar.getId(), avatar);
        System.out.println("AVATAR with ID=" + id + " successfully updated\n");
    }

    private void deleteAvatar() throws SQLException {
        System.out.println("\n[AVATAR / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        avatarController.delete(id);
        System.out.println("AVATAR with ID=" + id + " successfully deleted\n");
    }

//  comments
    private void getAllComments() throws SQLException {
    System.out.println("\n[COMMENTS / GET]");
    System.out.println(commentsController.findAll() + "\n");
    }

    private void getCommentsById() throws SQLException {
        System.out.println("\n[COMMENTS / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(commentsController.findOne(id) + "\n");
    }

    private Comments getCommentsInputs() {
        System.out.println("\nEnter author: ");
        String author = SCANNER.next();
        System.out.println("\nEnter text: ");
        String text = SCANNER.next();
        System.out.println("\nEnter amount of likes: ");
        Integer amount_of_likes = SCANNER.nextInt();
        System.out.println("\nEnter writing time: ");
        String writing_time = SCANNER.next();

        return new Comments(author, text, amount_of_likes, writing_time);
    }

    private void createComments() throws SQLException {
        System.out.println("\n[COMMENTS / CREATE]");
        Comments comments = getCommentsInputs();
        commentsController.create(comments);
        System.out.println("COMMENTS created.\n");
    }

    private void updateComments() throws SQLException {
        System.out.println("\n[COMMENTS / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Comments comments = getCommentsInputs();
        comments.setId(id);

        commentsController.update(comments.getId(), comments);
        System.out.println("COMMENTS with ID=" + id + " successfully updated\n");
    }

    private void deleteComments() throws SQLException {
        System.out.println("\n[COMMENTS / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        commentsController.delete(id);
        System.out.println("COMMENTS with ID=" + id + " successfully deleted\n");
    }

//  password
    private void getAllPassword() throws SQLException {
    System.out.println("\n[PASSWORD / GET]");
    System.out.println(passwordController.findAll() + "\n");
    }

    private void getPasswordById() throws SQLException {
        System.out.println("\n[PASSWORD / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(passwordController.findOne(id) + "\n");
    }

    private Password getPasswordInputs() {
        System.out.println("\nEnter password: ");
        String password = SCANNER.next();
        System.out.println("\nEnter user id: ");
        Integer user_id = SCANNER.nextInt();

        return new Password(password, user_id);
    }

    private void createPassword() throws SQLException {
        System.out.println("\n[PASSWORD / CREATE]");
        Password password = getPasswordInputs();
        passwordController.create(password);
        System.out.println("PASSWORD created.\n");
    }

    private void updatePassword() throws SQLException {
        System.out.println("\n[PASSWORD / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Password password = getPasswordInputs();
        password.setId(id);

        passwordController.update(password.getId(), password);
        System.out.println("PASSWORD with ID=" + id + " successfully updated\n");
    }

    private void deletePassword() throws SQLException {
        System.out.println("\n[PASSWORD / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        passwordController.delete(id);
        System.out.println("PASSWORD with ID=" + id + " successfully deleted\n");
    }

//  reactions
    private void getAllReactions() throws SQLException {
        System.out.println("\n[REACTIONS / GET]");
        System.out.println(reactionsController.findAll() + "\n");
    }

    private void getReactionsById() throws SQLException {
        System.out.println("\n[REACTIONS / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reactionsController.findOne(id) + "\n");
    }

    private Reactions getReactionsInputs() {
        System.out.println("\nEnter file name: ");
        Integer amount_of_views = SCANNER.nextInt();
        System.out.println("\nEnter file size in mb: ");
        Integer amount_of_emojis = SCANNER.nextInt();

        return new Reactions(amount_of_views, amount_of_emojis);
    }

    private void createReactions() throws SQLException {
        System.out.println("\n[REACTIONS / CREATE]");
        Reactions reactions = getReactionsInputs();
        reactionsController.create(reactions);
        System.out.println("REACTIONS created.\n");
    }

    private void updateReactions() throws SQLException {
        System.out.println("\n[REACTIONS / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Reactions reactions = getReactionsInputs();
        reactions.setId(id);

        reactionsController.update(reactions.getId(), reactions);
        System.out.println("REACTIONS with ID=" + id + " successfully updated\n");
    }

    private void deleteReactions() throws SQLException {
        System.out.println("\n[REACTIONS / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        reactionsController.delete(id);
        System.out.println("REACTIONS with ID=" + id + " successfully deleted\n");
    }

//  story
    private void getAllStory() throws SQLException {
        System.out.println("\n[STORY / GET]");
        System.out.println(storyController.findAll() + "\n");
    }

    private void getStoryById() throws SQLException {
        System.out.println("\n[STORY / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(storyController.findOne(id) + "\n");
    }

    private Story getStoryInputs() {
        System.out.println("Enter type of story (1 - picture/0 - video): ");
        int isPicture = SCANNER.nextInt();
        if (isPicture != 1) {
            isPicture = 0;
        }
        System.out.println("\nEnter file name: ");
        String file_name = SCANNER.next();
        System.out.println("\nEnter upload time: ");
        String upload_time = SCANNER.next();
        System.out.println("\nEnter file size in mb: ");
        Float file_size_in_mb = SCANNER.nextFloat();
        System.out.println("\nEnter duration in seconds: ");
        Integer duration_in_seconds = SCANNER.nextInt();
        System.out.println("\nEnter story line user id: ");
        Integer story_line_user_id = SCANNER.nextInt();
        System.out.println("\nEnter adress id: ");
        Integer adress_id = SCANNER.nextInt();

        return new Story(isPicture, file_name, upload_time, file_size_in_mb, duration_in_seconds,
                story_line_user_id, adress_id);
    }

    private void createStory() throws SQLException {
        System.out.println("\n[STORY / CREATE]");
        Story story = getStoryInputs();
        storyController.create(story);
        System.out.println("STORY created.\n");
    }

    private void updateStory() throws SQLException {
        System.out.println("\n[STORY / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Story story = getStoryInputs();
        story.setId(id);

        storyController.update(story.getId(), story);
        System.out.println("STORY with ID=" + id + " successfully updated\n");
    }

    private void deleteStory() throws SQLException {
        System.out.println("\n[STORY / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        storyController.delete(id);
        System.out.println("STORY with ID=" + id + " successfully deleted\n");
    }

//  storyLine
    private void getAllStoryLine() throws SQLException {
        System.out.println("\n[STORYLINE / GET]");
        System.out.println(storyLineController.findAll() + "\n");
    }

    private void getStoryLineById() throws SQLException {
        System.out.println("\n[STORYLINE / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(storyLineController.findOne(id) + "\n");
    }

    private StoryLine getStoryLineInputs() {
        System.out.println("\nEnter user id: ");
        Integer user_id = SCANNER.nextInt();
        System.out.println("\nEnter story author: ");
        String story_author = SCANNER.next();
        System.out.println("Enter watched status (1 - watched/0 - not watched): ");
        int isWatched = SCANNER.nextInt();
        if (isWatched != 1) {
            isWatched = 0;
        }

        return new StoryLine(user_id, story_author, isWatched);
    }

    private void createStoryLine() throws SQLException {
        System.out.println("\n[STORYLINE / CREATE]");
        StoryLine storyLine = getStoryLineInputs();
        storyLineController.create(storyLine);
        System.out.println("STORYLINE created.\n");
    }

    private void updateStoryLine() throws SQLException {
        System.out.println("\n[STORYLINE / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        StoryLine storyLine = getStoryLineInputs();
        storyLine.setUserId(id);

        storyLineController.update(storyLine.getUserId(), storyLine);
        System.out.println("STORYLINE with ID=" + id + " successfully updated\n");
    }

    private void deleteStoryLine() throws SQLException {
        System.out.println("\n[STORYLINE / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        storyLineController.delete(id);
        System.out.println("STORYLINE with ID=" + id + " successfully deleted\n");
    }

//    user
    private void getAllUser() throws SQLException {
        System.out.println("\n[USER / GET]");
        System.out.println(userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\n[USER / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findOne(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter nickname: ");
        String nickname = SCANNER.next();
        System.out.println("\nEnter avatar id: ");
        Integer avatar_id = SCANNER.nextInt();

        return new User(nickname, avatar_id);
    }

    private void createUser() throws SQLException {
        System.out.println("\n[USER / CREATE]");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("USER created.\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\n[USER / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs();
        user.setId(id);

        userController.update(user.getId(), user);
        System.out.println("USER with ID=" + id + " successfully updated\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\n[USER / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        userController.delete(id);
        System.out.println("USER with ID=" + id + " successfully deleted\n");
    }







}
