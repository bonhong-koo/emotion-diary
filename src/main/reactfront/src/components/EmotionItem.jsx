import "./EmotionItem.css";
import { getEmotionImage } from "../util/get-emotion-image";
const EmotionItem = ({ emotion, emotionName, isSelected, onClick }) => {
  return (
    <div
      onClick={onClick}
      className={`EmotionItem ${isSelected ? "EmotionItem_on" : ""}`}
    >
      <img className="emotion_img" src={getEmotionImage(emotion)} />
      <div className="emotion_name">{emotionName}</div>
    </div>
  );
};

export default EmotionItem;
