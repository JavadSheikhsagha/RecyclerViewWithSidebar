package ir.nikapps.recyclerviewsnappedtoside

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ir.nikapps.recyclerviewsnappedtoside.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainRvAdapter : RvMainAdapter
    private lateinit var sidebarRvAdapter : RvSidebarAdapter
    private lateinit var LLM: SnappingLinearLayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapters()

        setupViews()
    }

    private fun setupViews() {

        LLM = SnappingLinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        binding.rvMainActivityMain.apply {
            layoutManager = LLM
            adapter = mainRvAdapter
        }

        binding.rvMainActivitySideBar.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sidebarRvAdapter
        }
    }

    private fun setupAdapters() {

        mainRvAdapter = RvMainAdapter(DataStore.provideDataForMainRv() as MutableList){
            Log.i("LOG21", "setupAdapters: $it")
        }

        sidebarRvAdapter = RvSidebarAdapter(DataStore.provideDataForSidebar()
            ,{ it -> // on touch down
                Log.i("LOG11", "setupAdapters sidebar: $it")
                mainRvAdapter.getPositionOfItemWithNumber(it.toInt())?.let {
                    binding.rvMainActivityMain.smoothScrollToPosition(it.toInt())
                }
            },{ it -> // on touch up
                Log.i("LOG12", "setupAdapters sidebar: $it")
            }
        )
    }
}