package labosi.android.tvitko.restaurants;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tvitko on 11.4.2017..
 */

public class Comment implements Parcelable {

    private String nickname, commentText;

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nickname);
        dest.writeString(commentText);
    }

    private Comment(Parcel in){
        this.nickname = in.readString();
        this.commentText = in.readString();
    }

    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() {

        @Override
        public Comment createFromParcel(Parcel source) {
            return new Comment(source);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public Comment(String nickname, String commentText) {
        this.nickname = nickname;
        this.commentText = commentText;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
