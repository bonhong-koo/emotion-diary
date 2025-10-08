import "./App.css";
import axios from "axios";
import { useEffect, useState } from "react";
function App() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios({
      method: "GET",
      url: "https://jsonplaceholder.typicode.com/posts",
    }).then((response) => setPosts(response.data));
  }, []);

  return (
    <div>
      <ul>
        {posts.map((item) => (
          <li key={item.id}>{item.body}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
