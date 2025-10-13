import { useNavigate } from "react-router-dom";
import "./DiaryItem.css";
import Button from "./Button";
import { getEmotionImage } from "../util/get-emotion-image";

const DiaryItem = ({ no, emotion, title, content, date, id }) => {
  const nav = useNavigate();

  return (
    <div className="DiaryItem">
      <div
        className={`img_section img_section_${emotion}`}
        onClick={() =>
          nav(`/diary/${no}`, {
            state: { no, emotion, title, date, content, id },
          })
        }
      >
        <img src={getEmotionImage(emotion)} />
      </div>
      <div
        className="info_section"
        onClick={() =>
          nav(`/diary/${no}`, {
            state: { no, emotion, title, date, content, id },
          })
        }
      >
        <div className="date">{new Date(date).toLocaleDateString()}</div>
        <div className="title">{title}</div>
      </div>
      <div className="button_section">
        <Button
          onClick={() =>
            nav(`/edit/${no}`, {
              state: { no, emotion, title, date, content, id },
            })
          }
          text={"수정하기"}
        />
      </div>
    </div>
  );
};

export default DiaryItem;
