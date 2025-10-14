import Header from "../components/Header";
import Button from "../components/Button";
import "./../components/Info.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";
const Login = () => {
  const nav = useNavigate();

  function login(e) {
    e.preventDefault();
    axios
      .post("/api/login", {
        id: document.getElementById("id").value,
        password: document.getElementById("password").value,
      })
      .then((res) => {
        console.log(res.data);
        alert(res.data.message);

        if (res.data.success) {
          nav("/diaryList", { replace: true });
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
        title={"로그인"}
        leftChild={<Button text={"< 홈으로"} onClick={() => nav("/")} />}
        rightChild={
          <Button
            text={"회원가입"}
            type={"POSITIVE"}
            onClick={() => nav("/regist")}
          />
        }
      />
      <div className="Info">
        <div>
          <form className="form-group" action={"/loginProc"}>
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
            <Button text={"로그인"} type={"POSITIVE"} onClick={login} />
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
