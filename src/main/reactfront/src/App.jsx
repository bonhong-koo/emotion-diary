import "./App.css";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import New from "./pages/New";
import Regist from "./pages/Regist";
import Diary from "./pages/Diary";
import Edit from "./pages/Edit";
import DiaryList from "./pages/DiaryList";
import Notfound from "./pages/Notfound";
function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/diaryList" element={<DiaryList />} />
      <Route path="/login" element={<Login />} />
      <Route path="/regist" element={<Regist />} />
      <Route path="/diary/:no" element={<Diary />} />
      <Route path="/edit/:no" element={<Edit />} />
      <Route path="/new" element={<New />} />
      <Route path="*" element={<Notfound />} />
    </Routes>
  );
}

export default App;
