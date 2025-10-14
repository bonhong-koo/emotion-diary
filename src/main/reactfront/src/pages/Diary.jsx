import { useEffect } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import Button from "../components/Button";
import Header from "../components/Header";
import View from "../components/View";
import Getsession from "../util/Getsession";

const Diary = () => {
  const { state } = useLocation();
  const params = useParams();
  const nav = useNavigate();

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
  return (
    <div>
      <Header
        leftChild={<Button text={"< 뒤로가기"} onClick={() => nav(-1)} />}
        rightChild={
          <Button
            text={"수정하기"}
            onClick={() =>
              nav(`/edit/${params.no}`, {
                state: {
                  no: state.no,
                  emotion: state.emotion,
                  title: state.title,
                  date: state.date,
                  content: state.content,
                  id: state.id,
                },
              })
            }
          />
        }
        title={"일기"}
      />
      <View data={state} />
    </div>
  );
};

export default Diary;
