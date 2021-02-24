import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class main {
    public static void main(String[] args) throws Exception {
        FollowsTableDB followsTableDB = new FollowsTableDB();
        followsTableDB.put("@anotherName", "@firstLast");
        followsTableDB.get("@anotherName", "@newName");
        followsTableDB.update("@newName","@greatName", "firstName");
        followsTableDB.delete("@anotherName", "@firstLast");
    }

}
