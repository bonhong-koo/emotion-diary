import Header from "../components/Header";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";
import emotion_img from "./../assets/emotion_img.png";

const Home = () => {
  const nav = useNavigate();
  return (
    <div className="Home">
      <Header
        leftChild={<Button text={"로그인"} onClick={() => nav("/login")} />}
        rightChild={
          <Button
            text={"회원가입"}
            onClick={() => nav("/regist")}
            type={"POSITIVE"}
          />
        }
        title={"감정 일기장!"}
      />

      <img style={{ width: "100%" }} src={emotion_img} alt="이미지" />
    </div>
  );
};

export default Home;
