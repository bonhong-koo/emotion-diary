import "./../components/Info.css";
import Header from "../components/Header";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Regist = () => {
  const nav = useNavigate();
  function createUser(e) {
    e.preventDefault();
    axios
      .post("/api/create", {
        id: document.getElementById("id").value,
        password: document.getElementById("password").value,
        name: document.getElementById("name").value,
      })
      .then((res) => {
        alert(res.data.message);
        if (res.data.success) {
          nav("/login");
        } else {
          return;
        }
      })
      .catch((err) => {
        alert(err);
      });
  }
  return (
    <div>
      <Header
        leftChild={<Button text={"< 홈으로"} onClick={() => nav("/")} />}
        title={"회원 가입"}
        rightChild={
          <Button
            text={"로그인"}
            type={"POSITIVE"}
            onClick={() => nav("/login")}
          />
        }
      />
      <div className="Info">
        <div>
          <form className="form-group">
            <label htmlFor="name">이름</label>
            <input
              type="text"
              placeholder="구본홍"
              name="name"
              id="name"
              maxLength={7}
            />
            <label htmlFor="id">아이디</label>
            <input
              type="text"
              placeholder="아이디"
              name="id"
              id="id"
              maxLength={20}
            />
            <label htmlFor="password">비밀번호</label>
            <input
              type="password"
              placeholder="비밀번호"
              name="password"
              id="password"
              maxLength={20}
            />
            <Button text={"회원가입"} type={"POSITIVE"} onClick={createUser} />
          </form>
        </div>
      </div>
    </div>
  );
};

export default Regist;
