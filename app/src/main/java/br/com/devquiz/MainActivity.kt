package br.com.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialengine.HighlightTutorial
import com.example.tutorialengine.TutorialEngine
import com.example.tutorialengine.TutorialStep
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.adapter = TestAdapter()


//
//        HighlightTutorial.Builder(this) {
//            isDismissible = true
//            addStep("Teste 1", "Esse é o primeiro teste", recycler.layoutManager!!.findViewByPosition(2)!!)
//        }.build()

//        btnId.setOnClickListener {
//            container.addView(TutorialEngine(
//                context = this,
//                steps = listOf(
//                    TutorialStep(
//                        title = "Um teste",
//                        helpText = "Depois de 2 segundos esse cara apareceu, então ficou bem top né? hehe",
//                        views = listOf(
//                            recycler.layoutManager!!.findViewByPosition(2)!!
//                        )
//                    ),
//                    TutorialStep(
//                        title = "Um teste 2",
//                        helpText = "Depois de 2 usah uhd usahd uashdu asudash udah udsu adhu ada, então ficou bem top né? hehe",
//                        views = listOf(
////                            tutored,
////                            tutorede,
//                            recycler.layoutManager!!.findViewByPosition(0)!!,
//                            recycler.layoutManager!!.findViewByPosition(4)!!
//                        )
//                    )
//                )
//            ).apply { start() })
//        }
    }

}

class TestAdapter: RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    val list = listOf(
        "String","String","String","String","String"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.test_card, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}
