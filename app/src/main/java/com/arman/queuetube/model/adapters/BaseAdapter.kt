package com.arman.queuetube.model.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arman.queuetube.model.viewholders.BaseViewHolder

abstract class BaseAdapter<E, VH : BaseViewHolder<E>> @JvmOverloads constructor(protected var items: ArrayList<E> = ArrayList()) : RecyclerView.Adapter<VH>() {

    val isEmpty: Boolean
        get() = this.items.isEmpty()

    val isNotEmpty: Boolean
        get() = this.items.isNotEmpty()

    val isNullOrEmpty: Boolean
        get() = this.items.isNullOrEmpty()

    val all: ArrayList<E>
        get() = this.items

    operator fun get(index: Int): E {
        return this.items[index]
    }

    fun first(): E {
        return this.items.first()
    }

    fun first(predicate: (E) -> Boolean): E {
        return this.items.first(predicate)
    }

    fun firstOrNull(): E? {
        return this.items.firstOrNull()
    }

    fun firstOrNull(predicate: (E) -> Boolean): E? {
        return this.items.firstOrNull(predicate)
    }

    fun last(): E {
        return this.items.last()
    }

    fun last(predicate: (E) -> Boolean): E {
        return this.items.last(predicate)
    }

    fun lastOrNull(): E? {
        return this.items.lastOrNull()
    }

    fun lastOrNull(predicate: (E) -> Boolean): E? {
        return this.items.lastOrNull(predicate)
    }

    fun single(): E {
        return this.items.single()
    }

    fun single(predicate: (E) -> Boolean): E {
        return this.items.single(predicate)
    }

    fun singleOrNull(): E? {
        return this.items.singleOrNull()
    }

    fun singleOrNull(predicate: (E) -> Boolean): E? {
        return this.items.singleOrNull(predicate)
    }

    fun add(item: E): Boolean {
        val res = this.items.add(item)
        if (res) {
            this.notifyItemInserted(this.items.size - 1)
        }
        return res
    }

    fun add(index: Int, item: E): Boolean {
        this.items.add(index, item)
        this.notifyItemInserted(index)
        return true
    }

    fun addAll(items: Collection<E>): Boolean {
        val startRange = this.items.size
        val res = this.items.addAll(items)
        if (res) {
            this.notifyItemRangeInserted(startRange, items.size)
        }
        return res
    }

    fun remove(item: E): Boolean {
        val index = this.items.indexOf(item)
        val res = this.items.remove(item)
        if (res) {
            this.notifyItemRemoved(index)
        }
        return res
    }

    fun remove(index: Int): E? {
        val item = this.items.removeAt(index)
        if (item != null) {
            this.notifyItemRemoved(index)
        }
        return item
    }

    fun removeAll(data: Collection<E>): Boolean {
        val res = this.items.removeAll(data)
        this.notifyDataSetChanged()
        return res
    }

    fun pop(): E? {
        return this.remove(0)
    }

    fun clear() {
        this.items.clear()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        throw UnsupportedOperationException()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(this.items[position])
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    fun setAll(data: Collection<E>): Boolean {
        this.items.clear()
        val ret = this.items.addAll(data)
        this.notifyDataSetChanged()
        return ret
    }

}
