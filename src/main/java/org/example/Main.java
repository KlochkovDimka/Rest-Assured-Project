package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    private static MongoCollection<Document> mongoCollection;
    private static MongoDatabase database;

    public static void main(String[] args) {
        mongo();
    }

    public static void mongo() {
        MongoClient client = MongoClients.create("mongodb://javacode:bestEducationEver@80.66.64.141:27017/estim?authSource=admin");
        database = client.getDatabase("estim");
        // поиск коллекции
        getCollectByName("template");
        // просмотр всех документов в коллекции
        getAllDocument("userhrtemplates");
        // получение документа по ключу и значению
        Document document = getDocument("_id", 1015);

        System.out.println(document.get("_id"));

        client.close();
    }

    public static void getCollectByName(String name) {
        System.out.println("-------------------------------ВСЕ КОЛЛЕКЦИИ--------------------------------------------------------");
        for (String s : database.listCollectionNames()) {
            if (s.contains(name)) {
                System.out.println(s);
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public static void getAllDocument(String nameCollection) {
        System.out.println("------------------------------------------DOCUMENTS------------------------------------------------------");
        if (nameCollection == null) {
            return;
        }
        mongoCollection = database.getCollection(nameCollection);
        for (Document document : mongoCollection.find()) {
            System.out.println(document.toJson());
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public static Document getDocument(String key, Integer value) {
        System.out.println("------------------------------------------DOCUMENTDOCUMENT------------------------------------------------------");
        Document document = mongoCollection.find(
                new Document(key, value)).first();
        System.out.println(document.toJson());
        System.out.println("------------------------------------------------------------------------------");
        return document;
    }
}