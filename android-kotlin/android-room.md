# Android Room for SQL Database

## Three Types of Relationship in Database

### 1. One-to-One Relation

Assume there are `School` and `Director` tables. Normally, a school has one director and a director is responsible for a single school. Thus, there is one-to-one relationship between `School` and `Director` tables.

### 2. One-to-N Relation

Assume there are `School` and `Student` tables. Normally, a school has many students and a student goes to a single school. Thus, there is one-to-N relationship between `School` and `Student`.

### 3. N-to-M

Assume there are `Student` and `Subject` tables. A student can take multiple subjects at the same time, and a subject can handle multiple students at the same time. Therefore, there is N-to-M relation between `Student` and `Subject`.

## Annotations

- `@Entity(tableName="ABC")`: specifies a data class that it is an entity
- `@Embedded`
- `@Relation(parentColumn="commonColumn", entityColumn="commonColumn not PrimaryKey")`

## Data Access Object (DAO)

An interface which we define the functions how we access the data from database

- `@Insert(onConflict = OnConflictStrategy.REPLACE)`: If there is a conflict, we replace the existing one with the new one.
- `@Query("SELECT * FROM school WHERE schoolName = :schoolName)`: `:` is used to refer the parameter
- `@Transaction`: handles multi-threading issues
- `suspend` keyword