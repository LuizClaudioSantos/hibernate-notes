# My set of notes about Hibernate

This repository is a compilation of notes to myself about Hibernate, if you want to make any comments  in it, please go ahead.

## Basic Projet Setup (Branch)

I'm using a maven project in my example,  so the first thing to do is to import our dependencies. Now I will use:

```
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>4.3.6.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-annotations</artifactId>
            <version>3.5.6-Final</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.7</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.7</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.33</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
```

        
## Mapping annotations (Branch)

### JPA Annotation x Hibernate Annotation
- JPA Annotation is defined by the spec (JSR 137)
- Hibernate Annotation goes beyond the funcionalities in the spec (JSR 137)
 
### The class that represent a class should be annoted as Enity
- By default the name of class corresponds to the name of table.
- The annotation @Table could be used to add name of the that doesn't mach with the name of the table.
```
@Entity
@Table(name="FINANCES_USER")
public class User {
```


### Hibernate Fields Annotations

- The annotation @Id you mark the primary key of the table.
- The @Generate use the strategy to create new primary key values, another strategy that can be used GenerationType.SEQUENCE or table.
- With annotation @Column and the qualifier name you can mach the class and the column name.  

```
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long userId;
```

- If you don't want allow the update of a field, you can use the updatable equals to false: 

```
    @Column(name="CREATED_DATE", updatable = false)
    private Datea createDate;

    @Column(name="CREATED_BY", updatable = false)
    private String createBy;
```

- Use the annotation @Trasient to mark a property in the Entity as not database property.

```
   @Transient
   private boolean active;
```

### Hibernate Methods Annotations

- The same annotations can be used in methods instead fields.

```
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
```


