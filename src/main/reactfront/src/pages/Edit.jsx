import { useLocation, useNavigate, useParams } from "react-router-dom";
import Button from "../components/Button";
import Header from "../components/Header";
import Editor from "../components/Editor";
import axios from "axios";
import { useEffect } from "react";
import usePageTitle from "../hooks/usePageTitle";

const Edit = () => {
  const params = useParams();
  const nav = useNavigate();
  const { state } = useLocation();
  usePageTitle("일기 수정");

  useEffect(() => {
    if (!state) {
      alert("접근할 수 없습니다.");
      nav("/diaryList", { replace: true });
      return;
    }
  });
  if (!state) {
    return null;
  }
  function updateDiary(input) {
    axios
      .post("/api/updateDiary", input)
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
      });
  }

  function deleteDiary() {
    axios
      .post("/api/deleteDiary", { no: state.no })
      .then((res) => {
        alert(res.data.message);
        nav("/diaryList", { replace: true });
      })
      .catch((err) => {
        alert(err);
      });
  }

  return (
    <div>
      <Header
        leftChild={<Button text={"< 뒤로가기"} onClick={() => nav(-1)} />}
        rightChild={
          <Button text={"삭제"} type={"NEGATIVE"} onClick={deleteDiary} />
        }
        title={"일기 수정하기"}
      />
      <Editor data={state} onSubmit={updateDiary} />
    </div>
  );
};
export default Edit;
