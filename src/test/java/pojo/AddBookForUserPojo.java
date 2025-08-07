package pojo;

import java.util.List;

public class AddBookForUserPojo {
	
	/*{
		  "userId": "{{userId}}",
		  "collectionOfIsbns": [
		    {
		      "isbn": "{{first_isbn}}"
		    }
		  ]
		}&*/
	
	private  String userId;
	
	private List<CollectionOfIsbnPojo>collectionOfIsbns;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<CollectionOfIsbnPojo> getCollectionOfIsbns() {
		return collectionOfIsbns;
	}
	public void setCollectionOfIsbns(List<CollectionOfIsbnPojo> collectionOfIsbns) {
		this.collectionOfIsbns = collectionOfIsbns;
	}
	
		
	
	
	}


