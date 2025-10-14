import "./../components/Info.css";
import Header from "../components/Header";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Regist = () => {
  const nav = useNavigate();
  function createUser(e) {
    e.preventDefault();
    const id = document.getElementById("id");
    const password = document.getElementById("password");
    const name = document.getElementById("name");

    if (name.value === "") {
      alert("이름을 입력하세요.");
      name.focus();
      return;
    }

    if (id.value === "") {
      alert("아이디를 입력하세요.");
      id.focus();
      return;
    }
    if (password.value === "") {
      alert("비밀번호를 입력하세요.");
      password.focus();
      return;
    }
    (async () => {
      const res = await axios.get("/api/checkId", { params: { id: id.value } });
      if (res.data.duplicated) {
        alert(res.data.message);
        return;
      }

      await axios
        .post("/api/create", {
          id: id.value,
          password: password.value,
          name: name.value,
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
    })();
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
              required
            />
            <label htmlFor="id">아이디</label>
            <input
              type="text"
              placeholder="아이디"
              name="id"
              id="id"
              maxLength={20}
              required
            />
            <label htmlFor="password">비밀번호</label>
            <input
              type="password"
              placeholder="비밀번호"
              name="password"
              id="password"
              maxLength={20}
              required
            />
            <Button text={"회원가입"} type={"POSITIVE"} onClick={createUser} />
          </form>
        </div>
      </div>
    </div>
  );
};

export default Regist;
