package com.graphql.code;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.List;


public class StudentRepository {

    private final MongoCollection<Document> students;

    public UserRepository(MongoCollection<Document> students) {
        this.students = students;
    }
    


    public User findByFoafName(String name) {
        Document doc = students.find(eq("nombre", new ObjectId(id))).first();
        return student(doc);
    }
    
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (Document doc : students.find()) {
            allStudents.add(student(doc));
        }
        return allStudents;
    }
    
    public Student saveStudent(Student student) {
        Document doc = new Document();
        doc.append("nombre", student.getFoafName());
        students.insertOne(doc);
        return new Student(
                doc.get("_id").toString(),
                student.getFoafName()
                );
    }
    
    private Student student(Document doc) {
    if (doc == null) {
        return null;
    }
        return new Student(
                doc.get("_id").toString(),
                doc.getString("nombre")
                );
    }
}
