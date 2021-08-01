package com.example.phone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var contact:TextView;
    private lateinit var delete: Button;
    private lateinit var call:Button;
    private lateinit var save:Button;
    private lateinit var one:TextView;
    private lateinit var two:TextView;
    private lateinit var three:TextView;
    private lateinit var four:TextView;
    private lateinit var five:TextView;
    private lateinit var six:TextView;
    private lateinit var seven:TextView;
    private lateinit var eight:TextView;
    private lateinit var nine:TextView;
    private lateinit var zero:TextView;
    private lateinit var star:TextView;
    private lateinit var hash:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contact=findViewById(R.id.contact);
        delete=findViewById(R.id.del);
        call=findViewById(R.id.call);
        save=findViewById(R.id.save);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        star=findViewById(R.id.star);
        hash=findViewById(R.id.hash);

        zero.setOnClickListener{
            pressButton("0");
        }

        one.setOnClickListener{
            pressButton("1");
        }

        two.setOnClickListener{
            pressButton("2");
        }

        three.setOnClickListener{
            pressButton("3");
        }

        four.setOnClickListener{
            pressButton("4");
        }

        five.setOnClickListener{
            pressButton("5");
        }

        six.setOnClickListener{
            pressButton("6");
        }

        seven.setOnClickListener{
            pressButton("7");
        }

        eight.setOnClickListener{
            pressButton("8");
        }

        nine.setOnClickListener{
            pressButton("9");
        }
        star.setOnClickListener{
            pressButton("*");
        }

        hash.setOnClickListener{
            pressButton("#");
        }
        delete.setOnClickListener{
            contact.text="";
        }

        call.setOnClickListener{
            val intent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"${contact.text}"))  //ACTION_CALL
            startActivity(intent) //to start the call
        }

        save.setOnClickListener{
            val intent=Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+"${contact.text}"))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE,true)  //proving extra details to intet
            startActivity(intent)
        }

    }

    fun pressButton(str:String)
    {
        contact.append(str);
    }
}