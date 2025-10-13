import { useLocation, useNavigate, useParams } from "react-router-dom";
import Header from "../components/Header";
import Button from "../components/Button";
import View from "../components/View";
import { useEffect } from "react";
import axios from "axios";

const Diary = () => {
  const { state } = useLocation();
  const params = new useParams();
  const nav = new useNavigate();
  useEffect(() => {
    axios.get();
  }, []);
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
