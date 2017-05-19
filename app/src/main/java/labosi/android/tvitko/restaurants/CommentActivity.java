package labosi.android.tvitko.restaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CommentActivity extends AppCompatActivity {

    private TextView textViewComment;
    private TextView textViewNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment2);

        textViewNickname = (TextView) findViewById(R.id.textViewNickname);
        textViewComment = (TextView) findViewById(R.id.textViewComment);

        Comment comment = getIntent().getParcelableExtra("komentar");

        textViewNickname.setText(comment.getNickname());
        textViewComment.setText(comment.getCommentText());
    }

}
