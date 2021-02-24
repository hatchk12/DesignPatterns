

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class FollowsTableDB {

    Table table;

    public FollowsTableDB() throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-east-2")
                //.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("arn:aws:dynamodb:us-east-2:358400238271:table/follows", "us-east-2"))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        table = dynamoDB.getTable("follows");


    }


    public void put(String followedUser, String follower){

        final Map<String, Object> infoMap = new HashMap<String, Object>();
        infoMap.put("followeeName", followedUser.substring(1));
        infoMap.put("followerName", follower.substring(1));

        try {
            System.out.println("Adding a new item...");
            PutItemOutcome outcome = table
                    .putItem(new Item().withPrimaryKey("follower_handle", follower,
                            "followee_handle", followedUser).withMap("info", infoMap));

            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

        }
        catch (Exception e) {
            System.err.println("Unable to add item: " + followedUser + " " + follower);
            System.err.println(e.getMessage());
        }
    }

    public void get(String followedUser, String follower){

        GetItemSpec spec = new GetItemSpec().withPrimaryKey("follower_handle", follower, "followee_handle", followedUser);

        try {
            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);

        }
        catch (Exception e) {
            System.err.println("Unable to read item: " + followedUser + " " + follower);
            System.err.println(e.getMessage());
        }

    }



    public void delete(String followedUser, String follower){
        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey(new PrimaryKey("follower_handle", follower, "followee_handle", followedUser));



        try {
            System.out.println("Attempting a conditional delete...");
            table.deleteItem(deleteItemSpec);
            System.out.println("DeleteItem succeeded");
        }
        catch (Exception e) {
            System.err.println("Unable to delete item: " + followedUser + " " + follower);
            System.err.println(e.getMessage());
        }
    }

    public void update(String followedUser, String follower, String correctFollower){
        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("follower_handle", follower, "followee_handle", followedUser)
                .withUpdateExpression("set info.followerName = :f, info.followeeName=:u")
                .withValueMap(new ValueMap().withString(":f", correctFollower).withString(":u", followedUser.substring(1)))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Updating the item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Unable to update item: " + correctFollower+ " " + followedUser);
            System.err.println(e.getMessage());
        }
    }

}