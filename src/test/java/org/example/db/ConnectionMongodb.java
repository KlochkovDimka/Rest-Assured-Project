package org.example.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class ConnectionMongodb {

    private MongoCollection<Document> mongoCollection;
    private final MongoDatabase database;
    private final MongoClient client;

    public ConnectionMongodb() {
        client = MongoClients.create("mongodb://javacode:bestEducationEver@80.66.64.141:27017/estim?authSource=admin");
        database = client.getDatabase("estim");
    }

    public Document findEntity(String username) {
        mongoCollection = database.getCollection("users");
        Document myDoc = mongoCollection.find(new Document("email", "klochkov_dmitriy@itk.academy")).first();
        client.close();
        return myDoc;
    }

    public Document findEntityBuId(String id) {
        mongoCollection = database.getCollection("users");
        Document myDoc = mongoCollection.find(new Document("id", Integer.parseInt(id))).first();
        client.close();
        return myDoc;
    }

    public Document findQuest(String id) {
        mongoCollection = database.getCollection("themequestions");
        Document document = mongoCollection.find(new Document("_id", Integer.parseInt(id))).first();
        client.close();
        return document;
    }

    public Document findUpdateQuest(String id) {
        mongoCollection = database.getCollection("themequestions");
        Document document = mongoCollection.find(new Document("_id", Integer.parseInt(id))).first();
        client.close();
        return document;
    }

    public Document findQuiz(String name) {
        mongoCollection = database.getCollection("quizzes");
        Document document = mongoCollection.find(new Document("name", name)).first();
        client.close();
        return document;
    }

    public Document findModule(Integer moduleId) {
        mongoCollection = database.getCollection("coursemodules");
        Document document = mongoCollection.find(new Document("_id", moduleId)).first();
        client.close();
        return document;
    }

    public Document findCourse(Integer courseId) {
        mongoCollection = database.getCollection("courses");
        Document document = mongoCollection.find(
                new Document("_id", courseId)).first();
        client.close();
        return document;
    }

    public Document findExam(String examId) {
        mongoCollection = database.getCollection("exams");
        Document document = mongoCollection.find(
                new Document("_id", Integer.parseInt(examId))).first();
        client.close();
        return document;
    }

    public Document findTemplate(Integer templateId) {
        mongoCollection = database.getCollection("userhrtemplates");
        Document document = mongoCollection.find(
                new Document("_id", templateId)).first();
        client.close();
        return document;
    }
}
