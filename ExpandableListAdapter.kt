package com.example.brahimmasmoudi.expandingscrollbar

import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import kotlinx.android.synthetic.main.list_group.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class ExpandableListAdapter(
    private val mainActivity: MainActivity,
    private val listDataHeader: List<String>,
    private val listHashMap: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return listDataHeader.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listHashMap[listDataHeader.get(groupPosition)]!!.size
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }


    override fun getGroup(groupPosition: Int): Any {
        return listDataHeader[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return listHashMap.get(listDataHeader.get(groupPosition))!!.get(childPosition)

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }


    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val headerTitle = getGroup(groupPosition) as String

        val template = mainActivity.layoutInflater.inflate(R.layout.list_group, parent, false)
        template.lblListHeader.text = headerTitle

        return template
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childText = getChild(groupPosition, childPosition).toString()

        val template = mainActivity.layoutInflater.inflate(R.layout.list_item, parent, false)

        template.lblListItem.text = childText

        return template
    }
}




