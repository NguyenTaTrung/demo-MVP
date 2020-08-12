package sun.trainingcourse.demomvp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import sun.trainingcourse.demomvp.adapter.CakeAdapter
import sun.trainingcourse.demomvp.data.Cake
import sun.trainingcourse.demomvp.data.source.CakeRepository

class MainActivity : AppCompatActivity(), SearchContract.View {

    private var searchPresenter: SearchPresenter? = null
    private var cakeAdapter: CakeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchPresenter = SearchPresenter(this, CakeRepository())
        searchPresenter?.initData()
        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search_view, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.icSearch)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    override fun initView(listCake: MutableList<Cake>) {
        cakeAdapter = CakeAdapter()
        cakeAdapter?.updateCakeList(listCake)
        recyclerViewCake.layoutManager = LinearLayoutManager(this)
        recyclerViewCake.adapter = cakeAdapter
    }

    override fun showCakes(newListCake: MutableList<Cake>) {
        cakeAdapter?.updateCakeList(newListCake)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                searchPresenter?.searchCake(query)
            }
        }
    }
}
