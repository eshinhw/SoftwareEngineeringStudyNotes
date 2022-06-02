# React

## () vs {}

The following two statements are identical.

For single statements, `return` isn't needed. However, We need `return` keyword if we use curly braces.

```javascript

blogs.map(blog => (<h1> {b.title}))
blogs.map(blog => {return (<h1> {b.title})})

```

## Props

Inside `Home.js`, we have the following.

```javascript
const Home = () => {
  const [blogs, setBlogs] = useState([
    { title: "My new website", body: "body1", author: "mario", id: 1 },
    { title: "Welcome!", body: "body2", author: "suzuki", id: 2 },
    { title: "Hello", body: "body3", author: "mario", id: 3 },
  ]);

  const handleDelete = (id) => {
    console.log("delete a blog with id");
    const newBlogs = blogs.filter((blog) => blog.id != id);
    setBlogs(newBlogs);
  }

  return (
    <div className="home">
      // props are blogs, title and handleDelete.
      <BlogList blogs= {blogs} title="All Blogs" handleDelete={handleDelete}>
    </div>
  );
};

export default Home;
```

Inside `BlogList.js`, we have the following.

```javascript
// We have to access props provided in Home.js as input parameters.
// There are two ways of accessing props.
// 1) const BlogList = (props) => {} Then props.blogs, props.title and props.handleDelete
// 2) const BlogList = ({ blogs, title, handleDelete }) => {} Then blogs = props.blogs, title = props.title and handleDelete = props.handleDelete
const BlogList = (props) => {
  return (
    <div className="blog-list">
      <h2>{ title }</h2>
      // Why do we need key value?
      {blogs.map((blog) => (
        <div className="blog-preview" key={blog.id}>
          <h2>{ blog.title }</h2>
          <p>Written by { blog.author }</p>
          <button>Click Me</button>
        </div>      
      ))}
    </div>
  )
}

export default BlogList;
```

## useEffect

`useEffect` runs a function **every render** of the component.

import { useEffect } from 'react';

// doesn't return anything. We pass a function as an argument.
// Always run once when initial load is occurred.
useEffect(); 

Dependencies in useEffect

```javascript
useEffect(() => {
  console.log("use effect ran");
  console.log(name);
}, [name]);
```

The function provided in `useEffect` runs only when the variable in its dependencies is changed. 
