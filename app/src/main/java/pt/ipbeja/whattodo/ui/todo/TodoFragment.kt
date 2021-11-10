package pt.ipbeja.whattodo.ui.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipbeja.whattodo.R
import pt.ipbeja.whattodo.databinding.FragmentTodoBinding
import pt.ipbeja.whattodo.ui.todolist.TodoListFragmentDirections


class TodoFragment : Fragment() {

    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentTodoBinding.inflate(inflater).let {
            this.binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createTodo.setOnClickListener {
            findNavController().navigate(
                TodoListFragmentDirections.actionTodoListFragmentToTodoFragment()
            )
        }
    }

}