import { replace, useNavigate } from "react-router-dom";
import Button from "../components/Button";
import Header from "../components/Header";
import Editor from "../components/Editor";
import axios from "axios";

const New = () => {
  const nav = useNavigate();

  const onSubmit = (input) => {
    axios
      .post("/api/createDiary", {
        date: input.date,
        emotion: input.emotion,
        title: input.title,
        content: input.content,
      })
      .then((res) => {
        alert(res.data.message);
        if (res.data.success) {
          nav("/diaryList", { replace: true });
        } else {
          return;
        }
      })
      .catch((err) => {
        alert(err);
        nav("/"), { replace: true };
      });
  };
  return (
    <div>
      <Header
        leftChild={<Button text={"< 뒤로가기"} onClick={() => nav(-1)} />}
        title={"새 일기 작성"}
      />
      <Editor onSubmit={onSubmit} />
    </div>
  );
};

export default New;
