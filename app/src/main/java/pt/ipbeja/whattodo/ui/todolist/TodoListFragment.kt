package pt.ipbeja.whattodo.ui.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipbeja.whattodo.R
import pt.ipbeja.whattodo.databinding.FragmentTodoListBinding
import pt.ipbeja.whattodo.databinding.TodoListItemBinding
import pt.ipbeja.whattodo.model.Todo

class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding

    private lateinit var adapter: TodoAdapter
    // private val adapter = TodoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.adapter = TodoAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.todoList.adapter = this.adapter
        binding.todoList.layoutManager = LinearLayoutManager(requireContext())

        /*val list = MutableList(5) {
            Todo(it.toLong(), "Todo #$it", "")
        }
        adapter.data = list*/
    }


    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TodoListItemBinding.bind(view)

        fun bind(todo: Todo) {
            binding.todoTitle.text = todo.title
        }

    }


    inner class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {

        var data : MutableList<Todo> = mutableListOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {


            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_list_item, parent, false)
            return TodoViewHolder(v)
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun getItemCount() = data.size

    }

}