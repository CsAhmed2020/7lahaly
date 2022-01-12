package com.example.a7lahaly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Switch
import android.widget.Toast
import com.example.a7lahaly.adapter.AdapterHome
import com.example.a7lahaly.model.HomeItem
import kotlinx.android.synthetic.main.activity_homee.*

class HomeeActivity : AppCompatActivity() {
    var adapter: AdapterHome? = null
    var homeList = ArrayList<HomeItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homee)

        // load items
        homeList.add(HomeItem("Solve Quiz", R.drawable.ic_quiz))
        homeList.add(HomeItem("Tasks", R.drawable.ic_assignment))
        homeList.add(HomeItem("Solve Question", R.drawable.ic_results))
        homeList.add(HomeItem("Courses",R.drawable.ic_doubts))
        homeList.add(HomeItem("Material", R.drawable.ic_doubts))
        homeList.add(HomeItem("Answers", R.drawable.ic_date_sheet))
        homeList.add(HomeItem("Events", R.drawable.ic_event))
        homeList.add(HomeItem("Log Out", R.drawable.ic_logout))
        adapter = AdapterHome(this, homeList)

        gvHome.adapter = adapter

        gvHome.onItemClickListener= AdapterView.OnItemClickListener { parent, view, position, id ->
            when(position){
                0 ->  goQuiz()
                1 -> goAssignment()
                2 -> goResults()
                3 -> showToast("3")
                4 -> showToast("4")
                5 -> showToast("5")
                6 -> showToast("6")
                7 -> goRegister()
            }
        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(this@HomeeActivity, "Position $msg", Toast.LENGTH_LONG).show()
    }

    private fun goQuiz(){
        var quizIntent : Intent = Intent(this@HomeeActivity,QuizActivity::class.java)
        startActivity(quizIntent)
    }

    private fun goAssignment(){
        var assignmentIntent : Intent = Intent(this@HomeeActivity,AssignmentActivity::class.java)
        startActivity(assignmentIntent)
    }

    private fun goResults(){
        var resultIntent : Intent = Intent(this@HomeeActivity,ResultActivity::class.java)
        startActivity(resultIntent)
    }

    private fun goRegister(){
        var registerIntent : Intent = Intent(this@HomeeActivity,SplashActivity::class.java)
        startActivity(registerIntent)
    }



}